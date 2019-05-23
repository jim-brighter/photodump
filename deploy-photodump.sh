#!/bin/bash

set -e

# Authenticate to DigitalOcean
doctl auth init -t $DO_TOKEN

# Initialize variables
OLD_DROPLET=$(doctl compute droplet list 'photodump*' --format Name | sed -n 2p)
echo "Old Droplet: $OLD_DROPLET"

NEW_DROPLET=$([ $OLD_DROPLET = 'photodump-g' ] && echo 'photodump-b' || echo 'photodump-g')
echo "New Droplet: $NEW_DROPLET"

curl -L -o photodump-user-data.sh \
https://$GIT_USERNAME:$GIT_PASSWORD@raw.githubusercontent.com/jim-brighter/ops-secrets/master/photodump/photodump-user-data.sh

# # Launch new Photodump droplet
doctl compute droplet create $NEW_DROPLET \
--region nyc3 \
--size s-1vcpu-1gb \
--image 47146497 \
--ssh-keys 22134471,23526912,24637185 \
--enable-monitoring \
--tag-names $NEW_DROPLET \
--user-data-file photodump-user-data.sh \
--wait

# Get ID of new droplet
NEW_DROPLET_ID=$(doctl compute droplet list $NEW_DROPLET --format ID | sed -n 2p)
NEW_DROPLET_IP=$(doctl compute droplet list $NEW_DROPLET --format "Public IPv4" | sed -n 2p)
echo "New Droplet ID: $NEW_DROPLET_ID"

attempts=0
max_attempts=36

until $(curl --output /dev/null --silent --head --fail http://$NEW_DROPLET_IP:8080/swagger-ui.html); do

    if [ ${attempts} -eq ${max_attempts} ]; then
        echo "App failed to respond in a timely manner!"
        exit 1
    fi

    attempts=$(($attempts+1))
    echo "Waiting for app to respond at http://$NEW_DROPLET_IP ..."
    sleep 10
done

# Reassign photodump.xyz floating ip to new droplet
doctl compute floating-ip-action assign 138.197.57.143 $NEW_DROPLET_ID

# Move new droplet to photodump.xyz project
doctl projects resources assign 6d02298a-1a64-4549-a939-02ba2bf9287f --resource=do:droplet:$NEW_DROPLET_ID

# Delete old droplet
doctl compute droplet delete -f $OLD_DROPLET
