package ar.com.ada.api.billeteravirtual.services;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.*;
import ar.com.ada.api.billeteravirtual.repos.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PersonaService personaService;

    @Autowired
    BilleteraService billeteraService;

	public Usuario buscarPorUsername(String username) {
		return null;
	}

	public void login(String username, String password) {
	}
    
    public Usuario crearUsuario(String nombre,Integer paisId, Integer tipoDocumento, String documento, Date fechaNacimiento, String email, String password) {
        Persona persona = new Persona();
        persona.cargarPersona(fechaNacimiento, paisId, tipoDocumento, documento, nombre);

        
        Usuario usuario = new Usuario();
        usuario.cargarUsuario(email, password);
        persona.setUsuario(usuario);
        personaService.grabar(persona);

        Billetera billetera = new Billetera();
        billetera.crearCuentas();
        persona.setBilletera(billetera);

        billeteraService.grabar(billetera);
        billeteraService.cargarSaldo(billetera.getBilleteraId(), new BigDecimal(500),"ARS","Bienvenido al sistemaGracias por crearte unUsuario de Regalo te damos $500","regalo");
        
        return usuario;
    }

}