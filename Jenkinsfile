stage("INIT") {
	load "jenkins.properties"
	println TAG_VERSION
}

stage("MERGE") {
	if (GIT_BRANCH == "ci") {
		sh """
			git fetch -p
			git checkout master
			git merge --abort ci
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