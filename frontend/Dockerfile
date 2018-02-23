FROM node:alpine
EXPOSE 9001

RUN /bin/ash -c 'npm install http-server -g'

ADD index.html app/index.html
ADD css/ app/css/
ADD js/ app/js/

CMD ["http-server", "-p", "9001", "app/"]