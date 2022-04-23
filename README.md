# Backend para la API Diorismos que servira a la Clinica Dental Dr.Kelvin Cano

## Endpoint de Paciente

Este endpont contiene los siguientes metodos HTTP

- **POST**

  `Uso:` para crear paciente o obtener uno ya existente

  `Ruta Completa`: {{IPServidor}}/diorismos/api/paciente

  `Recibe`: un objeto json de body de tipo Paciente

  Ejemplo:

  ```JSON
  {
    "dpi": "3148239481301",
    "nombre": "Kelvin Alejandro",
    "apellido": "Cano Bolaños",
    "fechaNacimiento": "2000-06-05",
    "direccion": "Huehuetenango",
    "telefono": "77648980",
    "celular": "55668980"
  }
  ```

  `Devuelve`: un objeto json con el id del paciente, puede tener un status code _`201-CREATED`_ o _`200-OK`_ si el paciente ya exisitia

  Ejemplo:

  ```JSON
  {
    "idPaciente": 1,
    "dpi": "3148239481301",
    "nombre": "Kelvin Alejandro",
    "apellido": "Cano Bolaños",
    "fechaNacimiento": "2000-06-05",
    "direccion": "Huehuetenango",
    "telefono": "77648980",
    "celular": "55668980"
  }
  ```

## Endpoint de Cita

Este endpont contiene los siguientes metodos HTTP

- **GET /available/{fecha}**

  `Uso:` sirve para obtener una lista de de las horas disponibles para agendar una cita en determinada fecha

  `Ruta Completa`: {{IPServidor}}/diorismos/api/cita/available/{fecha}

  `Recibe`: un parametro de fecha, con formato AAAA MM DD

  Ejemplo:

  ```
  GET {{IPServidor}}/cita/available/2022-03-31
  ```

  `Devuelve`: una lista con las horas disponibles de la fecha solicitada

  Ejemplo:

  ```JSON
  [
    "9:00",
    "10:00",
    "12:00",
    "13:00",
    "15:00",
    "16:00"
  ]
  ```

- **POST**

  `Uso:` sirve crear y registrar una nueva cita

  `Ruta Completa`: {{IPServidor}}/diorismos/api/cita

  `Recibe`: un objeto json de body de tipo Cita

  Ejemplo:

  ```JSON
  {
    "fecha": "2022-03-31",
    "hora": "12:00:00",
    "pacienteIdPaciente": 1
  }
  ```

  `Devuelve`: una lista con las horas disponibles de la fecha solicitada

  Ejemplo:

  ```JSON
  [
    "9:00",
    "10:00",
    "12:00",
    "13:00",
    "15:00",
    "16:00"
  ]
  ```
