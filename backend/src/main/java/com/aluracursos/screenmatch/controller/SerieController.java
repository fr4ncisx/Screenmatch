package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping("")
    public List<SerieDTO> mostrarMensaje() {
        return service.obtenerTodasLasSeries();
    }
    @GetMapping("/top5")
    public List<SerieDTO> mostrarTop5(){
        return service.obtenerTop5();
    }
    @GetMapping("/lanzamientos")
    public List<SerieDTO> recientes(){
        return service.obtenerLanzamientosRecientes();
    }
    @GetMapping("/{id}")
    public SerieDTO obtenerId(@PathVariable("id") Long id){
        return service.obtenerPorId(id);
    }
    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obtenerTodasLasTemporadas(@PathVariable("id") Long id){
       return service.obtenerTodasLasTemporadas(id);
    }
    @GetMapping("/{id}/temporadas/{num_Temp}")
    public List<EpisodioDTO> obtenerTemporadasPorNumero(@PathVariable("id") Long id,
                                                        @PathVariable("num_Temp") Long num_Temp){
        return service.obtenerEpisodioPorTemporada(id, num_Temp);
    }
    @GetMapping("/categoria/{genero}")
    public List<SerieDTO> obtenerSeriesPorGenero(@PathVariable String genero){
        return service.obtenerSeriesPorCategoria(genero);
    }
    @GetMapping("/{id}/temporadas/top")
    public List<EpisodioDTO> topEpisodiosPorTemporada(@PathVariable Long id){
        return service.obtenerTopEpisodios(id);
    }
}
