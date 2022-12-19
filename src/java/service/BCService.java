package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import main.Cont;
import model.BusinessCard;

public class BCService {
   private static File file =null;
   private static ArrayList<BusinessCard> bcList = null;
    
    public static void loadFile(){
       
        file =new File(Cont.path,"WEB-INF/Data/data.txt");
        bcList =  new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while((line =(br.readLine()))!=null){
        String[] pieces = line.split("[|]");
        BusinessCard bc = new BusinessCard(Integer.parseInt(pieces[0]),pieces[1] ,pieces[2],pieces[3],pieces[4]);
        bcList.add(bc);
        }
       } catch (FileNotFoundException ex) {
          
       } catch (IOException ex) {
           
       }
    }
    public static ArrayList<BusinessCard> read() {
        return bcList;
    }
    public static BusinessCard read(int id) {
    
        BusinessCard bctbr = null;
        for(BusinessCard bc : bcList){
        
            if(bc.getId()==id){
                bctbr=bc;
                break;
            }
        }
        return bctbr;
    }
    public static boolean create(BusinessCard bc) {
       boolean tbr =false;
        if(!exists(bc)){
            bc.setId(getMaxId()+1);
            bcList.add(bc);
            tbr = true;
        }
        return tbr;
    }
    public static boolean delete(BusinessCard bc){
        boolean tbr = false;
        if(bc!=null){
            bcList.remove(bc);
            tbr = true;
        }
        return tbr;
    }
    public static boolean update(BusinessCard bc){
         boolean tbr= false;
         for (BusinessCard businessCard : bcList) {
            if(businessCard.getId()== bc.getId()){
                businessCard.setName(bc.getName());
                businessCard.setTel(bc.getTel());
                businessCard.setEmail(bc.getEmail());
                businessCard.setAddress(bc.getAddress());
                tbr = true;
                break;
            }
        }
         return tbr;
    }
    private static int getMaxId() {
    
       return bcList.size();
        
    }
    private static boolean exists(BusinessCard bc) {
        boolean tbr =false;
        for(BusinessCard bcelement : bcList){
        
            if(bc.getName().equals(bcelement.getName())&& bc.getTel().equals(bcelement.getTel())){
            
                bc.setId(bcelement.getId());
                tbr = true;
                break;
            }
        }
        return tbr;
    }
    
    public static boolean save() {
        boolean tbr = false;
        try(PrintWriter pw = new PrintWriter(new FileWriter(file))){
            for (BusinessCard businessCard : bcList) {
                
                pw.println(businessCard.getId()+"|"+businessCard.getName()+"|"+businessCard.getTel());
               
            }
            tbr = true;
        } catch (IOException ex) {
          
       }
       
     return tbr;
    }
    
}
