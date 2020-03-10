node{
    stage('Source') {
        //git branch: 'master', url: 'git@github.com:brovensmile/BROVEN_V100R001C00.git'
        //git url: 'https://github.com/jglick/simple-maven-project-with-tests.git'
        ws('BROVEN_V100R001C00'){
        checkout  changelog:true, poll:true, scm:[
                 $class: 'GitSCM', 
                 branches: [[name: '*/master']], 
                 userRemoteConfigs: [[url: 'git@github.com:brovensmile/BROVEN_V100R001C00.git']],
                 ]
        }  
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
