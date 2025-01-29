pipeline {
    agent any 
    stages {
        stage("build image" ) {
            steps {
                script{
                    echo "building the docker image.."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t adilnu/backend:first ."
                        sh " echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push adilnu/backend:first" 
                    }

                }
            }
        }
        stage("test") {
            steps {
                echo "npm test"
            }
        }
        stage("deploy") {
            steps {
                echo "npm deploy"
            }
        }
    }
}
