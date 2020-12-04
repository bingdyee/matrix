/*
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

##
sudo firewall-cmd --zone=public --add-port=23000/tcp --permanent
sudo firewall-cmd --zone=public --add-port=22122/tcp --permanent
sudo firewall-cmd --zone=public --add-port=80/tcp --permanent
sudo systemctl restart firewalld

# Start

sudo fdfs_trackerd /etc/fdfs/tracker.conf
sudo fdfs_storaged /etc/fdfs/storage.conf
sudo /usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf

# Stop

fdfs_trackerd /etc/fdfs/tracker.conf stop
fdfs_storaged /etc/fdfs/storage.conf stop

 */
package io.github.matrix.fastdfs;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Noa Swartz
 * @date 2020/12/04
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FastDFSTest {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("E:\\background.jpg");
        String fileName = file.getName();
        long length = file.length();
        String extName = fileName.substring(fileName.indexOf(".") + 1);
        FileInputStream inputStream = new FileInputStream(file);
        StorePath path = fastFileStorageClient.uploadFile(inputStream, length, extName, null);
        System.err.println(path.getGroup());
        System.err.println(path.getPath());
        System.err.println(path.getFullPath());
    }

}
