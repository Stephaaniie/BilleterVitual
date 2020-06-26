package ar.com.ada.api.billeteravirtual.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.billeteravirtual.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

     /*1.Metodo: Crear Usuario
    1.1-->Crear una Persona(setearle un usuario)
    1.2-->crear un usuario
    1.3-->Crear una billetera(setearle una persona)
    1.4-->Crear una cuenta en pesos y otra en dolares*/

    /* 2. Metodo: Iniciar Sesion 
    2.1-- recibe el username y la password
    2.2-- vamos a validar los datos
    2.3-- devolver un verdadero o falso
    */
    
}