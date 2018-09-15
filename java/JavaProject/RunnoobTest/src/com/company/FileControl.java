package com.company;

import java.io.File;

public class FileControl {

    public FileControl(){
        System.out.println("\n***** FileControl *****");
    }

    public void newFile(File folder){
        if(!folder.exists()){
            folder.mkdir();
            System.out.printf("File '%s' created\n", folder.getPath());
        } else {
            System.out.printf("File '%s' is exist\n", folder.getPath());
        }
    }

    public void deleteFile(File folder){
        File[] files = folder.listFiles();
        if(files != null){
            for (File f:files){
                if(f.isDirectory()){
                    deleteFile(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
        System.out.printf("File '%s' deleted\n", folder.getPath());
    }

}
