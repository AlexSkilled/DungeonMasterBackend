apt install wget -y

mkdir tmp
cd tmp

release=$(lsb_release -cs)
os=$(lsb_release -is | awk '{print tolower($0)}')

wget -O containerdio.deb https://download.docker.com/linux/$os/dists/$release/pool/stable/amd64/containerd.io_1.4.4-1_amd64.deb
wget -O dockercli.deb https://download.docker.com/linux/$os/dists/$release/pool/stable/amd64/docker-ce-cli_20.10.6~3-0~$os-${release}_amd64.deb
wget -O docker.deb https://download.docker.com/linux/$os/dists/$release/pool/stable/amd64/docker-ce_20.10.6~3-0~$os-${release}_amd64.deb

curl -L "https://github.com/docker/compose/releases/download/1.29.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose

dpkg -i containerdio.deb
dpkg -i dockercli.deb
dpkg -i docker.deb

cd ..
rm -rf tmp
