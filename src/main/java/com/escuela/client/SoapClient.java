package com.escuela.client;

import com.escuela.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

public class SoapClient extends WebServiceGatewaySupport {
    public PostAgregarAlumnoResponse agregarAlumno(Alumno alumno){
        PostAgregarAlumnoRequest request = new PostAgregarAlumnoRequest();
        request.setAlumno(alumno);
        return (PostAgregarAlumnoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8090/ws", request,
                        new SoapActionCallback("http://www.soap.com/gen/postAgregarAlumnoRequest"));
    }

    public GetMostrarAlumnosResponse mostrarAlumnos(){
        GetMostrarAlumnosRequest getMostrarAlumnosRequest = new GetMostrarAlumnosRequest();

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.soap.com/gen/getMostrarAlumnosRequest");

        GetMostrarAlumnosResponse getMostrarAlumnosResponse =
                (GetMostrarAlumnosResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws", getMostrarAlumnosRequest, soapActionCallback);

        return getMostrarAlumnosResponse;
    }

    public GetBuscarAlumnoResponse buscarAlumno(String nombre){
        GetBuscarAlumnoRequest getBuscarAlumnoRequest = new GetBuscarAlumnoRequest();
        getBuscarAlumnoRequest.setNombre(nombre);

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.soap.com/gen/getMostrarAlumnosRequest");

        GetBuscarAlumnoResponse getBuscarAlumnoResponse =
                (GetBuscarAlumnoResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws", getBuscarAlumnoRequest, soapActionCallback);

        return getBuscarAlumnoResponse;
    }

    public DeleteAlumnoResponse eliminarAlumno(int id){
        DeleteAlumnoRequest deleteAlumnoRequest = new DeleteAlumnoRequest();
        deleteAlumnoRequest.setId(id);

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.soap.com/gen/getMostrarAlumnosRequest");

        DeleteAlumnoResponse deleteAlumnoResponse =
                (DeleteAlumnoResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws", deleteAlumnoRequest, soapActionCallback);

        return deleteAlumnoResponse;
    }

    public UpdateAlumnoResponse editarAlumno(Alumno alumno){
        UpdateAlumnoRequest updateAlumnoRequest = new UpdateAlumnoRequest();
        updateAlumnoRequest.setAlumno(alumno);

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.soap.com/gen/getMostrarAlumnosRequest");

        UpdateAlumnoResponse updateAlumnoResponse =
                (UpdateAlumnoResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws", updateAlumnoRequest, soapActionCallback);

        return updateAlumnoResponse;
    }
}
