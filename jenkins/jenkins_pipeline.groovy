node {
    /* Requires the Docker Pipeline plugin to be installed */
    sh '''
         whoami
    '''
    docker.image('node:7-alpine').inside('-v /opt/:/opt') {
        stage('Test') {
            sh '''node --version
                  sleep 300
            '''
            
        }
    }
}
