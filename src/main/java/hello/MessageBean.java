package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.beans.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author viter
 */
public class MessageBean implements Serializable {
    
	static Cumprimento cumprimento;
	static LocalDateTime local;
    private String msg;
        
    public MessageBean() {
      local = LocalDateTime.now();
      int horario = local.getHour(); 
        
      Cumprimento.setHorario(horario);
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String value) {
        switch (value){
            case "":
            case "pt":
                msg = "Alô, ";
                cumprimento = new Cumprimento("Bom dia", "Boa tarde", "Boa noite");
                break;
            case "en":
                msg = "Hello, ";
                cumprimento = new Cumprimento("Good morning", "Good afternoon", "Good night");
                break;
            case "fr":
                msg = "Bonjour, ";
                cumprimento = new Cumprimento(msg, "Bon après-midi", "Bonne nuit");
                break;
            case "de":
                msg = "Hallo, ";
                cumprimento = new Cumprimento("Guten morgen", "Guten tag", "Gute nacht");
                break;
            case "es":
            	msg = "Hola, ";
            	cumprimento = new Cumprimento("Buen día", "Buenas tardes", "Buenas noches");
            	break;
            case "it":
            	msg = "Ciao, ";
            	cumprimento = new Cumprimento("Buongiorno", "Buon pomeriggio", "Buona Notte");
                break;
        }
    }
}
