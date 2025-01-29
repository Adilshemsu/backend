def buildImage () {
    echo "building the docker image.."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t adilnu/backend:first ."
        sh " echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push adilnu/backend:first" 
    }    
}

def testApp (){
    echo "testing the application.."
}

def deployApp (){
    echo "deploying the application.."
    echo "Deployed version: ${params.VERSION}"
}

return this