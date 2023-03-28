package com.manuelsarante.ApiBeBank.web;


import com.manuelsarante.ApiBeBank.domain.Logs;
import com.manuelsarante.ApiBeBank.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogsController {

    @Autowired
    LogsService logsService;
    @PostMapping("/save")
    public ResponseEntity<?> saveLogs(@RequestBody Logs logs){
        logsService.insert(logs);
        return ResponseEntity.ok(logs);
    }
    @GetMapping("/list")
    public ResponseEntity<?> listLogs() {
        List<Logs> logss = logsService.getAll();
        return ResponseEntity.ok(logss);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Logs> getObjectById(@PathVariable Long id) {
        Logs logs = logsService.findById(id);
        if (logs==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(logs);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletelogs(@PathVariable Long id){
        Logs logs = logsService.findById(id);
        logsService.delete(logs);
        return ResponseEntity.ok("Logs Eliminado");
    }

}
