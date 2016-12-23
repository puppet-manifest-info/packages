class packages::services {
        $services = ["openssh-server", "openssh-clients"]
        services { $services:
                ensure => present,
                ensure => running,
        }

}
