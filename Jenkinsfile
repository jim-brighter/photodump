node {
	stage("INIT") {
		deleteDir()
		sh """
			git clone git@github.com:jim-brighter/photodump.git -b ${GIT_BRANCH} .
			git fetch -p
		"""
		load "./jenkins.properties"
		println TAG_VERSION
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
				git push ${TAG_VERSION}
			"""
		}
	}
}