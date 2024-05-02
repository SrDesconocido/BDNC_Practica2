/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package org.uv.BDNC;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author octav
 */
public interface RepositoryPersona extends MongoRepository<Persona, String> {
    
}
