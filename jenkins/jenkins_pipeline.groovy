node{
    stage('Source') {
        git branch: 'master', url: 'git@github.com:brovensmile/BROVEN_V100R001C00.git'
    }  

    /* Requires the Docker Pipeline plugin to be installed */
     
    sh '''
        whoami
    '''
    
    stage('Test') {
    docker.image('node:7-alpine').inside('-v /opt/:/opt') {
        sh '''node --version
            sleep 30
        '''
        }
    }
}
