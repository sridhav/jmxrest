$script = <<SCRIPT
    yum -y install wget vim
    wget http://repo.mysql.com/mysql-community-release-el7-5.noarch.rpm
    rpm -ivh mysql-community-release-el7-5.noarch.rpm
    yum -y install mysql-server
    systemctl start mysqld
    systemctl enable mysqld
SCRIPT

nodes = [
  { :hostname => 'mysql', :ip => '192.168.50.50', :box => 'centos/7' }
]

Vagrant.configure("2") do |config|
    nodes.each do |node|
        config.vm.box = node[:box]
        config.vm.box_check_update = true
        config.vbguest.auto_update = true
        config.vm.define node[:hostname] do |nodeconfig|
            nodeconfig.vm.hostname = node[:hostname] + ".box"
            nodeconfig.vm.network :private_network, ip: node[:ip]
            memory = node[:ram] ? node[:ram] : 512;
            cpus = node[:cpu] ? node[:cpu] : 1;
            nodeconfig.vm.provider :virtualbox do |vb|
                vb.cpus = cpus
                vb.memory = memory
                vb.customize ["modifyvm", :id, "--cpuexecutioncap", "50"]
            end
            nodeconfig.vm.provision :shell, inline: $script
        end
    end
end
