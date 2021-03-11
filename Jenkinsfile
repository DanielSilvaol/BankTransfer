pipeline {
	agent any
	
	stages {
		stage("build") {
			steps {
				echo 'building the application...'
				echo 'building the ...'
			}
		}
		
		stage("test") {
			steps {
				echo 'testing the application...'
			}
		}
		
		stage("deploy") {
			steps {
				echo 'deploying the application...'
				 sh 'mvn -B -DskipTests clean package' 
			}
		}
	}
}
