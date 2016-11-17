node ('puppet-master'){
   
   timestamps {

      stage('Updating deploy puppet-modules') {
      
            checkout scm
         
            sh 'echo jenkins | sudo -S puppet parser validate /manifests/init.pp && echo jenkins | sudo -S puppet-lint /manifests/init.pp'
            sh 'echo jenkins | sudo -S cp -rf manifests /etc/puppet/modules/packages/ && echo jenkins | sudo -S chown -R root:root /etc/puppet/modules/packages'
      
            step([$class: 'WsCleanup'])
        
      }
   
   }

}
