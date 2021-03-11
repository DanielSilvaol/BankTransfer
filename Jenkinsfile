pipeline {
	agent any
	tools {
        	maven 'Maven'
        	jdk 'jdk8'
    	}
	stages {
		stage ('Initialize') {
            		steps {
                		sh '''
                    		echo "PATH = ${PATH}"
                    		echo "M2_HOME = ${M2_HOME}"
               			''' 
            		}
        	}
		stage("build") {
			steps {
				echo 'building the application...'
				sh 'mvn clean install' 
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
				sh 'java -jar .\target\transfer-1.0.0-SNAPSHOT.jar'
			}
		}
	}
}
