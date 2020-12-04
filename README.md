# Matrix
Matrix provided a tested, study, tutorial, hands-on coding experience for everyone.


## FastDFS

yum -y install gcc make libevent libevent-devel perl 

yum -y install pcre-devel zlib-devel openssl openssl-devel


## tracker.conf
base_path = /opt/fastdfs/tracker
## storage.conf
base_path = /opt/fastdfs/tracker
store_path0 = /opt/fastdfs/storage/files
tracker_server = 192.168.137.7:22122

## Install Nginx with FastDFS module
configure --prefix=/usr/local/nginx --add-module=fastdfs-nginx-module-1.22/src
make 
make install
## mod_fastdfs.conf
base_path = /opt/fastdfs/nginx_mod
tracker_server = 192.168.137.7:22122
url_have_group_name = true
store0_path = /opt/fastdfs/storage/files

## nginx.conf
location ~ /group[1-9]/M0[0-9] {
    ngx_fastdfs_module;
}

# Start

sudo fdfs_trackerd /etc/fdfs/tracker.conf
sudo fdfs_storaged /etc/fdfs/storage.conf
sudo /usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf

# Stop

fdfs_trackerd /etc/fdfs/tracker.conf stop
fdfs_storaged /etc/fdfs/storage.conf stop