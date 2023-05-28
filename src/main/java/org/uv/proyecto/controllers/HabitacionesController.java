/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.proyecto.models.Dispositivos;
import org.uv.proyecto.services.DispositivosService;

/**
 *
 * @author wbpat
 */
@Controller
public class HabitacionesController {
    
    private DispositivosService dispositivoService;
    
    @RequestMapping("/dispositivos")
    public List<Dispositivos> listDisp(){
        return dispositivoService.listaDispositivos();
    }
}
