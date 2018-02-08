def TAG_VERSION

node {
	stage("INIT") {
		deleteDir()
		sh """
			git clone git@github.com:jim-brighter/photodump.git -b ${GIT_BRANCH} .
			git fetch -p
		"""
		load "./jenkins.properties"
		println "App version: ${APP_VERSION}"
		TAG_VERSION = "${APP_VERSION}.${env.BUILD_NUMBER}"
		currentBuild.displayName = "${GIT_BRANCH}-${TAG_VERSION}"
	}

	stage("MERGE") {
		if (GIT_BRANCH == "ci") {
			sh """
				git checkout master
				git merge ci
				git push origin master
			"""
		}
		else if (GIT_BRANCH == "master") {
			sh """
				git tag ${TAG_VERSION}
				git push origin ${TAG_VERSION}
			"""
		}
	}
}