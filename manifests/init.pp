class packages {
        include services
        $packages = ["java-1.8.0-openjdk.x86_64", "curl", "sudo", "system-config-services", "wget", "mlocate", "vim-enhanced.x86_64", "git", "nodejs", "npm", "cronie"]
        package { $packages:
                ensure => present,
        }
}
