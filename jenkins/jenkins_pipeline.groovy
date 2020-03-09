node{
    stage('Source') {
        //git branch: 'master', url: 'git@github.com:brovensmile/BROVEN_V100R001C00.git'
        //git url: 'https://github.com/jglick/simple-maven-project-with-tests.git'
        checkout  changelog:true, poll:true,clearWorkspace:true,scm:[
                 $class: 'GitSCM', 
                 branches: [[name: '*/master']], 
                 userRemoteConfigs: [[url: 'git@github.com:brovensmile/BROVEN_V100R001C00.git']],
                 workspaceUpdater: [$class: 'UpdateUpdater']
                 ]
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
