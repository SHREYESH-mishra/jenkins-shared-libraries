def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
        sh """
            echo $dockerhubpass | docker login -u $dockerhubuser --password-stdin
            docker tag ${Project}:${ImageTag} $dockerhubuser/${Project}:${ImageTag}
            docker push $dockerhubuser/${Project}:${ImageTag}
        """
    }
}
