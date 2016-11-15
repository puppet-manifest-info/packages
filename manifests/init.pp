class packages {
        $packages = ["java-1.7.0-openjdk-devel", "curl", "wget", "vim-enhanced.x86_64", "git", "nodejs", "npm", "cronie"]
        package { $packages:
                ensure => present,
        }
}
