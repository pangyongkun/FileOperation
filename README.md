#   文件操作--保存文件
##  1.新建文件
    //第一个参数为文件路径，第二个参数为文件名
    File file = new File(context.getFilesDir(), FILE_NAME);
    

##  2.修改文件

    FileWriter fileWriter=new FileWriter(file);
    fileWriter.write(username+":"+pwd);
    fileWriter.close();
          
##  3.读取文件

    File file=new File(context.getFilesDir(),FILE_NAME);
    BufferedReader br=new BufferedReader(new FileReader(file));
    result=br.readLine();
    br.close();  
        
##  4.删除文件

     return file.delete();
