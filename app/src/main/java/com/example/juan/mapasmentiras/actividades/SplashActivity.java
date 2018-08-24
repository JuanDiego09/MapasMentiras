package com.example.juan.mapasmentiras.actividades;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.juan.mapasmentiras.R;
import com.example.juan.mapasmentiras.entidades.LugaresVo;
import com.example.juan.mapasmentiras.utilidades.Conexion;
import com.example.juan.mapasmentiras.utilidades.Utilidades;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Conexion conn;

    ArrayList<LugaresVo> listaLugares;
    LugaresVo lugaresVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        conn = new Conexion(getApplicationContext(), "mapas", null, 1);
        listaLugares = new ArrayList<>();
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Centro Comercial Portal del Quindío.");
        lugaresVo.setDescripcionCorta("El Centro Comercial Portal del Quindio, ubicado en el norte de Armenia, es el centro comercial, más grande e importante del Quindío.");
        lugaresVo.setUbicacion("Av Bolivar # 19 Norte 46 Armenia");
        lugaresVo.setDescripcionLarga("El Centro Comercial Portal del Quindio, ubicado en el norte de Armenia, es el centro comercial, más grande e importante del Quindío. Cuenta con 100 locales donde se encuentran representadas las marcas comerciales nacionales e internacionales más importantes.\n" +
                "En su mall de comidas rápidas encontrará reconocidos restaurantes como Frisby, hamburguesas El Corral y Presto entre otras.\n" +
                "Todo esta oferta se complementa con una espectacular diverzona y cuatro (4) modernas salas de Cinecolombia.");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Calima Centro Comercial Armenia");
        lugaresVo.setDescripcionCorta("Calima Armenia nace de la necesidad de la ciudad y la región de abrir nuevos espacios comerciales para atender un mercado creciente");
        lugaresVo.setUbicacion("Avenida Centenario # 3 - 180. Armenia");
        lugaresVo.setDescripcionLarga("Unicentro Armenia inaugurado en Septiembre de 2.012,  ubicado en la  esquina de la Avenida Bolívar con la Calle 4B donde antiguamente funcionó la fabrica de Bavaria, a pocos minutos del Centro de Armenia.El centro comercial cuenta con 40 mil metros cuadrados, 129 locales comerciales y 410 parqueaderos.\n" +
                "Entre las marcas comerciales que ya confirmarón su presencia en Unicentro Armenia, se destacan: Almacenes Exito, Pepe Ganga, Recreatec, Arturo Calle, entre otros.");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Unicentro - Armenia.");
        lugaresVo.setDescripcionCorta("Unicentro Armenia inaugurado en Septiembre de 2.012,  ubicado en la  esquina de la Avenida Bolívar con la Calle 4B ");
        lugaresVo.setUbicacion("Avenida Bolívar con Calle 4B");
        lugaresVo.setDescripcionLarga("Calima Armenia nace de la necesidad de la ciudad y la región de abrir nuevos espacios comerciales para atender un mercado creciente. Un proyecto con sentido ambiental, hace énfasis en su diseño bioclimático de arquitectura abierta que optimiza el uso de la energía. Calima, un verdadero modelo de sostenimiento, será desarrollado en amplios espacios para atender necesidades comerciales, de servicios, entretenimiento y parqueo.");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Parque del Café");
        lugaresVo.setDescripcionCorta("El Parque del Café  brinda a sus visitantes diversión y entretenimiento a través de la cultura cafetera");
        lugaresVo.setUbicacion("Montenegro Quindio");
        lugaresVo.setDescripcionLarga("El Parque del Café  brinda a sus visitantes diversión y entretenimiento a través de la cultura cafetera, dando a conocer la importancia del café y del gremio cafetero en el desarrollo económico del país, en un ambiente de naturaleza, con innovadoras, confiables y seguras atracciones  culturales y mecánicas, comprometidos con la conservación del medio ambiente, el bienestar de nuestros empleados y el de la comunidad.");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Panaca");
        lugaresVo.setDescripcionCorta("Somos el primer parque temático agropecuario en el mundo y el más grande en Latinoamérica");
        lugaresVo.setUbicacion("Kilometro 7, Vía Vereda Kerman Quimbaya, Quindío.");
        lugaresVo.setDescripcionLarga("Somos el primer parque temático agropecuario en el mundo y el más grande en Latinoamérica, te ofrecemos una experiencia única llena de diversión e interacción con el campo, en la que podrás encontrar los Shows más sorprendentes, las más impresionantes Estaciones temáticas y la colección de zoología doméstica más grande del mundo, donde vivirás una experiencia inigualable entre los animales, la naturaleza y el hombre.");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Salento");
        lugaresVo.setDescripcionCorta("Salento es un municipio colombiano en el departamento del Quindío.");
        lugaresVo.setUbicacion("Municipio en Colombia");
        lugaresVo.setDescripcionLarga("Salento es un municipio colombiano en el departamento del Quindío. Llamado el padre del Quindío por ser el municipio más antiguo de este departamento, es conocido como el municipio Cuna del árbol Nacional \"La Palma de Cera\", posee una gran variedad de atractivos turísticos entre ellos el Valle de Cocora en donde se puede encontrar un paisaje lleno de naturaleza, como el Barranquero o Momotus momota un ave comúnmente divisada, hacer caminatas ecológicas y disfrutar de los hermosos paisajes de esta localidad. ");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Eco Parque Peñas Blancas");
        lugaresVo.setDescripcionCorta("ofrece un recorrido lleno de aire, naturaleza y paisaje");
        lugaresVo.setUbicacion("Corregimiento la virginia en Calarcá");
        lugaresVo.setDescripcionLarga("EL ECOPARQUE PEÑAS BLANCAS ofrece un recorrido lleno de aire, naturaleza y paisaje, el cual nos transporta por los parajes más bellos de nuestra región, entre un bosque lleno de verde que parece infinito al contemplar la hoya del Quindío e inalcanzable al observar");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("La Pequeña Granja de Mamá Lulú");
        lugaresVo.setDescripcionCorta("La Pequeña Granja de Mamá Lulú, es un paraíso ecológico");
        lugaresVo.setUbicacion("Quimbaya Quindio");
        lugaresVo.setDescripcionLarga("La Pequeña Granja de Mamá Lulú, es un paraíso ecológico que a través de años de estudio, esfuerzo y dedicación, ha permitido crear un ambiente en donde se integran el hombre y la naturaleza en armonía y cooperación. La propuesta que busca esta granja integral, es generar un cambio de actitud personal hacia la vida y la naturaleza, para no seguirla agrediendo, no seguir acabando con nuestros recursos y destruir todo a nuestro paso.");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("La Pequeña Granja de Mamá Lulú");
        lugaresVo.setDescripcionCorta("La Pequeña Granja de Mamá Lulú, es un paraíso ecológico");
        lugaresVo.setUbicacion("Quimbaya Quindio");
        lugaresVo.setDescripcionLarga("La Pequeña Granja de Mamá Lulú, es un paraíso ecológico que a través de años de estudio, esfuerzo y dedicación, ha permitido crear un ambiente en donde se integran el hombre y la naturaleza en armonía y cooperación. La propuesta que busca esta granja integral, es generar un cambio de actitud personal hacia la vida y la naturaleza, para no seguirla agrediendo, no seguir acabando con nuestros recursos y destruir todo a nuestro paso.");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Parque Los Arrieros");
        lugaresVo.setDescripcionCorta("EL Parque Los Arrieros es un lugar que ofrece servicios turísticos de recreación");
        lugaresVo.setUbicacion("Quimbaya Quindio");
        lugaresVo.setDescripcionLarga("EL Parque Los Arrieros es un lugar que ofrece servicios turísticos de recreación, esparcimiento y aprendizaje; en torno a la cultura de la arriería; a través de escenarios artísticos, culturales y áreas de entretenimiento que conforman un abanicó de opciones para que los visitantes, disfruten de una agradable experiencia en nuestras instalaciones.");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        setContentView(R.layout.activity_splash);
//////////////////////////HOTELES____HOTELES______HOTELES/////////////////////////////////
///////////////////////////////////////////////////////////////////
       /* lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Hotel Bolivar Plaza");
        lugaresVo.setDescripcionCorta("Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ");
        lugaresVo.setUbicacion("Dirección: Calle 21a No. 14-17, Armenia");
        lugaresVo.setDescripcionLarga("Hotel sencillo, sin mayores pretensiones pero bien ubicado, cerca del centro de armenia, con facilidad de acceso para visitantes de negocios. Adecuado para pasar una o dos noches, es acogedor y el servicio es muy bueno. Dirección Calle 21a No. 14-17, Armenia");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("Allure Aroma Mocawa Hotel");
        lugaresVo.setDescripcionCorta(" Categoría del hotel:3,5 estrella(s),");
        lugaresVo.setUbicacion("Dirección: Carrera 14 No. 9N-00, Armenia");
        lugaresVo.setDescripcionLarga("Disfruta de un hotel de excelente calidad y con un sello personal que lo hace ser único. Con una atención cinco estrellas, lo hace una de las mejores alternativas en hospedaje es Armenia. Con una perfecta ubicación y contar con un buen restaurante y un centro comercial, Dirección Carrera 14 No. 9N-00, Armenia");
        listaLugares.add(lugaresVo);
///////////////////////////////////////////////////////////////////
        lugaresVo = new LugaresVo();
        lugaresVo.setNombre("El Roble");
        lugaresVo.setDescripcionCorta("En el Restaurante El Roble encontrarás comida típica de la región con la mejor sazón");
        lugaresVo.setUbicacion("Dirección: Vía Armenia – Pereira");
        lugaresVo.setDescripcionLarga("En el Restaurante El Roble encontrarás comida típica de la región con la mejor sazón, y espacios para el esparcimiento familiar en nuestro Café Rockola y Parque Recreativo y Granja. El Roble es reconocido por su tradición gastronómica, sus amplios y verdes espacios para el entretenimiento familiar y su excelente ubicación, donde podrás vivir y sentir el paisaje cultural cafetero, apreciar el municipio de Salento y el nevado del Tolima. En el Restaurante El Roble encontrarás comida típica de la región con la mejor sazón, y espacios para el esparcimiento familiar en nuestro Café Rockola y Parque Recreativo y Granja.");
        listaLugares.add(lugaresVo);*/
///////////////////////////////////////////////////////////////////
        registroSitios();
        registroHoteles();
        registroRestaurantes();
///////////////////////////////////////////////////////////////////
        CountDownTimer tiempo;

        tiempo = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent miIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(miIntent);
                finish();
            }
        };
        tiempo.start();
    }


    private void registroSitios() {
        db = conn.getWritableDatabase();
        db=conn.getReadableDatabase();

        db.execSQL("delete from "+Utilidades.TABLA_SITIOS);

        ContentValues values = new ContentValues();
        for (int i = 0; i < listaLugares.size(); i++) {
            values.put(Utilidades.SITIOS_DESCRIPCION_LARGA, listaLugares.get(i).getDescripcionLarga());
            values.put(Utilidades.SITIOS_DESCRIPCION_CORTA, listaLugares.get(i).getDescripcionCorta());
            values.put(Utilidades.SITIOS_NOMBRE, listaLugares.get(i).getNombre());
            values.put(Utilidades.SITIOS_UBIBACION, listaLugares.get(i).getUbicacion());
            long registroExitoso = db.insert(Utilidades.TABLA_SITIOS, Utilidades.SITIOS_NOMBRE, values);
        }

    }

    private void registroHoteles() {

    }

    private void registroRestaurantes() {

    }

}
