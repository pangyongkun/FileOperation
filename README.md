#   文件操作--保存文件
##  1.新建文件

    File file = new File(context.getFilesDir(), FILE_NAME);
    

##  2.修改文件

    FileWriter fileWriter=new FileWriter(file);
                fileWriter.write(username+":"+pwd);
                fileWriter.close();
                
##  3.删除文件

     return file.delete();
