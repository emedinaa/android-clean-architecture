# android-clean-architecture
Sample Android  app using clean architecture

1. ## Principios de Clean Architecture 

   - [Uncle bob´s Clean Architecture link](https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html)
   
   - Principios S.O.L.I.D
      
      * Principio de Responsabilidad Única (S: Single responsability)
      
      * Principio Abierto/Cerrado (O: Open/Close)
      
      * Principio de Sustitución de Liskov ( L: Sustitution liskov)
      
      * Principio de Segregación de Interfaces ( I: Segregation interface)
      
      * Principio de Inversión de Dependencias ( D: Dependencies Inversion)
         
2. Clean Architecture en Android

 **Capa de Presentación**
 
   En la capa de presentación estoy usando el patrón MVP para dividir responsabilidades.
   En este caso estoy usando el proyecto de la APP como capa de presentación y es proyecto Android
   
 **Capa de Datos**
 
   En la capa de datos,es un módulo Android y  estoy usando Retrofit para consumir servicios Rest de BackendLess. 
   Esta capa tambien tiene entidades relacionadas a los servicios REST y base de Datos local.
   
   Elementos :
      
      - Entidades de Datos
      
      - Implementación de los Interactors dependiente del origen de datos
      
      - Mappers, para convertir las entidades de datos a entidades de dominio.
   
   
 **Capa de Dominio**
   En la capa de dominio ,es un módulo Java y  están declaradas las entidades con que construyo mi applicación. Que son independientes de la capa de datos. Para poder comunicar esta capa con las demas uso interfaces.
   
   Elementos :
   
         - Entidades de Dominio
         
         - Interactors
         
         - Callbacks 
         
3. Presentación
  - Clean Architecture [https://docs.google.com/presentation/d/1Eg2V_0j0UO1V3gvYBMYomsMjS9cxD-p-CldPB68ZQxs/edit?usp=sharing](https://docs.google.com/presentation/d/1Eg2V_0j0UO1V3gvYBMYomsMjS9cxD-p-CldPB68ZQxs/edit?usp=sharing)

4. Ejemplo

  - Perú Travel APP
  
  - Video 
  
  ![](https://github.com/emedinaa/android-clean-architecture/blob/master/video.gif?raw=true)
  
  - Dependencias :
  
    - Retrofit 2.0
    
    - OkHttp 2.5.0
    
    - OkHttp Logging 3.3.1
    
    - OkHttp Gson 2.1.0

    - Glide 3.7.0
    
    - Butterknife 7.0.1





