/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.util;

import java.util.ResourceBundle;

/**
 *
 * @author Felps
 */
public class PropertiesUtil {
    private static final String FILE_MSG = "br\\com\\felps\\salao\\properties/msg";
    private static final ResourceBundle resMsg = ResourceBundle.getBundle(FILE_MSG);

    public static String MSG_ERROR_CADASTRAR = "msg.error.cadastrar";
    public static String MSG_ERROR_EDITAR = "msg.error.editar";
    public static String MSG_ERROR_BUSCAR = "msg.error.buscar";
    public static String MSG_ERROR_LISTAR = "msg.error.listar";
    public static String MSG_ERROR_REMOVER = "msg.error.remover";
    
    public static String getMsgValue(String key){
        return resMsg.getString(key);
    }

}
