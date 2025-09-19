import EntidadesTraza1.*;
import EntidadesTraza2.*;
import Repositorio.InMemoryRepository;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //============================= TRAZA1 =============================

        InMemoryRepository<Empresa> repositorio = new InMemoryRepository<>();

        LocalTime horaApertura = LocalTime.of(9, 0, 0);
        LocalTime horaCierre = LocalTime.of(21, 0, 0);

        // ========================== PAÍSES ================================
        Pais argentina = Pais.builder()
                .id(1L)
                .nombre("Argentina")
                .build();

        // ========================== PROVINCIAS ================================
        Provincia bsas = Provincia.builder()
                .id(1L)
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();

        Provincia cba = Provincia.builder()
                .id(2L)
                .nombre("Córdoba")
                .pais(argentina)
                .build();

        // ========================== LOCALIDADES ================================
        Localidad caba = Localidad.builder()
                .id(1L)
                .nombre("CABA")
                .provincia(bsas)
                .build();

        Localidad lp = Localidad.builder()
                .id(2L)
                .nombre("La Plata")
                .provincia(bsas)
                .build();

        Localidad ccp = Localidad.builder()
                .id(3L)
                .nombre("Córdoba Capital")
                .provincia(cba)
                .build();

        Localidad vcp = Localidad.builder()
                .id(4L)
                .nombre("Villa Carlos Paz")
                .provincia(cba)
                .build();

        // ========================== DOMICILIOS ================================
        Domicilio domcaba = Domicilio.builder()
                .id(1L)
                .calle("Pedrito Pedrero")
                .numero(3591)
                .cp(1000)
                .localidad(caba)
                .build();

        Domicilio domlp = Domicilio.builder()
                .id(2L)
                .calle("Cabrita Cabrero")
                .numero(1918)
                .cp(1900)
                .localidad(lp)
                .build();

        Domicilio domccp = Domicilio.builder()
                .id(3L)
                .calle("Loquito Loquero")
                .numero(49)
                .cp(5000)
                .localidad(ccp)
                .build();

        Domicilio domvcp = Domicilio.builder()
                .id(4L)
                .calle("Bolita Bolero")
                .numero(2121)
                .cp(5152)
                .localidad(vcp)
                .build();

        // ========================== SUCURSALES ================================
        Sucursal sucursal1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal CABA")
                .horarioApertura(horaApertura)
                .horarioCierre(horaCierre)
                .es_Casa_Matriz(true)
                .domicilio(domcaba)
                .build();

        Sucursal sucursal2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal La Plata")
                .horarioApertura(horaApertura)
                .horarioCierre(horaCierre)
                .domicilio(domlp)
                .build();

        Sucursal sucursal3 = Sucursal.builder()
                .id(3L)
                .nombre("Sucursal Córdoba Capital")
                .horarioApertura(horaApertura)
                .horarioCierre(horaCierre)
                .domicilio(domccp)
                .build();

        Sucursal sucursal4 = Sucursal.builder()
                .id(4L)
                .nombre("Sucursal Villa Carlos Paz")
                .horarioApertura(horaApertura)
                .horarioCierre(horaCierre)
                .domicilio(domvcp)
                .build();

        // ========================== EMPRESAS ================================
        Empresa empresa1 = Empresa.builder()
                .nombre("Mc Donalds")
                .razonSocial("McDonals SRL")
                .cuit(234234345)
                .logo("McDonalds.png")
                .build();

        Empresa empresa2 = Empresa.builder()
                .nombre("Burger King")
                .razonSocial("BurgerKing SRL")
                .cuit(1231236123)
                .logo("BK.png")
                .build();

        sucursal1.setEmpresa(empresa1);
        sucursal2.setEmpresa(empresa1);
        sucursal3.setEmpresa(empresa2);
        sucursal4.setEmpresa(empresa2);

        repositorio.guardar(empresa1);
        repositorio.guardar(empresa2);

        //============================= TRAZA2 =============================

        InMemoryRepository<Categoria> categoriaRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> articuloInsumoRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> articuloManufacturadoRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();

        // ========================== CATEGORÍAS ================================

        Categoria pizzas = Categoria.builder().denominacion("Pizzas").esInsumo(false).build();
        Categoria sandwiches = Categoria.builder().denominacion("Sandwiches").esInsumo(false).build();
        Categoria bebidas = Categoria.builder().denominacion("Bebidas").esInsumo(false).build();
        Categoria insumos = Categoria.builder().denominacion("Insumos").esInsumo(true).build();

        categoriaRepository.guardar(pizzas);
        categoriaRepository.guardar(sandwiches);
        categoriaRepository.guardar(bebidas);
        categoriaRepository.guardar(insumos);

        // ========================== UNIDADES MEDIDA ================================

        UnidadMedida kg = UnidadMedida.builder().denominacion("Kg").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();
        UnidadMedida gramos = UnidadMedida.builder().denominacion("Gramos").build();

        unidadMedidaRepository.guardar(kg);
        unidadMedidaRepository.guardar(litro);
        unidadMedidaRepository.guardar(gramos);

        // ========================== ARTICULO INSUMO ================================

        ArticuloInsumo sal = ArticuloInsumo.builder()
                .denominacion("Sal")
                .precioCompra(1.0)
                .stockActual(100)
                .stockMinimo(10)
                .stockMaximo(200)
                .esParaElaborar(true)
                .unidadMedida(gramos)
                .categoria(insumos)
                .build();

        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .precioCompra(0.5)
                .stockActual(50)
                .stockMinimo(5)
                .stockMaximo(100)
                .esParaElaborar(true)
                .unidadMedida(kg)
                .categoria(insumos)
                .build();

        ArticuloInsumo aceite = ArticuloInsumo.builder()
                .denominacion("Aceite")
                .precioCompra(3.0)
                .stockActual(30)
                .stockMinimo(3)
                .stockMaximo(60)
                .esParaElaborar(true)
                .unidadMedida(litro)
                .categoria(insumos)
                .build();

        ArticuloInsumo carne = ArticuloInsumo.builder()
                .denominacion("Carne")
                .precioCompra(5.0)
                .stockActual(20)
                .stockMinimo(2)
                .stockMaximo(40)
                .esParaElaborar(true)
                .unidadMedida(kg)
                .categoria(insumos)
                .build();

        articuloInsumoRepository.guardar(sal);
        articuloInsumoRepository.guardar(harina);
        articuloInsumoRepository.guardar(aceite);
        articuloInsumoRepository.guardar(carne);

        // ========================== IMAGEN ARTICULO ================================

        ImagenArticulo img1 = ImagenArticulo.builder().
                name("HawaianaPizza1").url("http://example.com/pizza1").build();
        ImagenArticulo img2 = ImagenArticulo.builder().name("HawaianaPizza2").url("http://example.com/pizza2").build();
        ImagenArticulo img3 = ImagenArticulo.builder().name("HawaianaPizza3").url("http://example.com/pizza3").build();
        ImagenArticulo img4 = ImagenArticulo.builder().name("LomoCompletoLomo1").url("http://example.com/lomo1").build();
        ImagenArticulo img5 = ImagenArticulo.builder().name("LomoCompletoLomo2").url("http://example.com/lomo2").build();
        ImagenArticulo img6 = ImagenArticulo.builder().name("LomoCompletoLomo3").url("http://example.com/lomo3").build();

        // ========================== ARTICULO MANUFACTURADO DETALLE ================================

        ArticuloManufacturadoDetalle detalle1PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();

        ArticuloManufacturadoDetalle detalle2PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(harina)
                .build();

        ArticuloManufacturadoDetalle detalle3PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();

        ArticuloManufacturadoDetalle detalle1LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();

        ArticuloManufacturadoDetalle detalle2LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();

        ArticuloManufacturadoDetalle detalle3LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(carne)
                .build();

        // ========================== ARTICULO MANUFACTURADO ================================

        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaina")
                .precioVenta(12.0)
                .descripcion("Pizza con piña y jamón")
                .tiempoEstimadoMinutos(20)
                .preparacion("Hornear por 20 minutos")
                .categoria(pizzas)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1PizzaHawaina, detalle2PizzaHawaina, detalle3PizzaHawaina)))
                .build();

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .denominacion("Lomo Completo")
                .precioVenta(15.0)
                .descripcion("Lomo completo con todos los ingredientes")
                .tiempoEstimadoMinutos(25)
                .preparacion("Cocinar a la parrilla por 25 minutos")
                .categoria(sandwiches)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img4, img5, img6)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1LomoCompleto, detalle2LomoCompleto, detalle3LomoCompleto)))
                .build();

        articuloManufacturadoRepository.guardar(pizzaHawaina);
        articuloManufacturadoRepository.guardar(lomoCompleto);
    }
}
