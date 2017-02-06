# android-clean-architecture
Sample Android  app using clean architecture

## 1. Principios de Clean Architecture 

   - [Uncle bob´s Clean Architecture ](https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html)
   
   - Principios S.O.L.I.D
      
      * Principio de Responsabilidad Única (S: Single responsibility principle)
      
      * Principio de Abierto/Cerrado (O: Open/closed principle)
      
      * Principio de Sustitución de Liskov ( L: Liskov substitution principle)
      
      * Principio de Segregación de Interfaces ( I: Interface segregation principle)
      
      * Principio de Inversión de Dependencias ( D: Dependency inversion principle))
         
## 2. Clean Architecture en Android

 **Capa de Presentación**
 
   En la capa de presentación uso el patrón Model-View-Presenter(MVP) para dividir responsabilidades.
   En este caso el proyecto de la APP se comporta como la  capa de presentación y depende del SDK de Android.
   
   Elementos :
   
      * Presenter
      
      * View
      
      * Model
   
 **Capa de Datos**
 
   La capa de datos es un módulo Android , uso Retrofit para consumir servicios REST de BackendLess y SqLite para la persistencia local.
   En esta capa tambien se encuentran entidades relacionadas a los servicios y a la base de Datos .
   
   Elementos :
      
      * Entidades de Datos
      
      * Implementación de los Interactors dependiente del origen de datos
      
      * Mappers, permite convertir las entidades de datos a entidades de dominio.
   
   
 **Capa de Dominio**
 
  La capa de dominio es un módulo Java ,  donde se encuentran las entidades base para construir la App . Estas entidades  deben ser independientes de las entidades usadas en la capa de datos.
 Respecto a la comunicación con otras capas, utilizo interfaces , ya sea para declarar casos de uso en los interactor o como callbacks para la respuesta a operaciones en las capas de presentación y de datos.
   
  Elementos :
   
     * Entidades de Dominio
         
     * Interactors
         
     * Callbacks 
         
## 3. Presentación
  - Clean Architecture [https://docs.google.com/presentation/d/1Eg2V_0j0UO1V3gvYBMYomsMjS9cxD-p-CldPB68ZQxs/edit?usp=sharing](https://docs.google.com/presentation/d/1Eg2V_0j0UO1V3gvYBMYomsMjS9cxD-p-CldPB68ZQxs/edit?usp=sharing)

## 4. Ejemplo

  - Perú Travel APP
  
  - Video 
  
  ![](https://github.com/emedinaa/android-clean-architecture/blob/master/video.gif?raw=true)
  
  - Dependencias :
  
    * Retrofit 2.0
    
    * OkHttp 2.5.0
    
    * OkHttp Logging 3.3.1
    
    * OkHttp Gson 2.1.0

    * Glide 3.7.0
    
    * Butterknife 7.0.1





