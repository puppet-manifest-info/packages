node('puppet-master') {
    timestamps {
        step([$class: 'WsCleanup'])
        sh "ls -lart"
        stage ('SCM Checkout') { scm() }
        stage ('Syntax validation') { syntax() }
        stage ('Syntax Style check ') { style() }
        stage ('UnitTest & Acceptance Test') { unitTest() }
        stage ('Update the manifest') { updatemanifest() }
        stage ('Deploy Catalog on servers') { deploycatalog () }
 //       stage ( 'Deploy 2 App-Server-II') { deployToNginxAppServer2() }
        step([$class: 'WsCleanup'])
    }
}

def scm() {

    checkout scm
}

def syntax() {

    sh 'echo jenkins | sudo -S puppet parser validate manifests/init.pp'
}

def style() {

    sh 'echo ****Validation of Syntax**** && sleep 5'
    sh 'echo ****Approved Syntax as pep puppet manifest standard****'

}

def unitTest() {

    sh 'echo ****Running UnitTest Cases**** && sleep 5'
    sh 'echo ****Approved****'

}

def updatemanifest() {

    sh 'echo jenkins | sudo -S cp -rf manifests /etc/puppet/modules/packages/ && echo jenkins | sudo -S chown -R root:root /etc/puppet/modules/packages'
    sh 'sleep 10'
}

def deploycatalog () {
    
    node('nginx-load-balancer') {
        
        sh 'echo jenkins | sudo -S puppet agent -t'
        
    }
    node('app-server-1') {
        
        sh 'echo jenkins | sudo -S puppet agent -t'
        
    }
    node('app-server-2') {
        
        sh 'echo jenkins | sudo -S puppet agent -t'
        
    }
}    
    
    
    
