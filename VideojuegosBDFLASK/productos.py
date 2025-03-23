from bson import ObjectId
from app import create_app
from mongo import mongo
from flask import Blueprint, jsonify, request
from bson.json_util import dumps
from datetime import datetime

prod=Blueprint("products", __name__)
app = create_app()

#Método que retorna todos los productos
# @prod.route('/productos/get_all', methods=['GET'])
# def listar_prod():
#     data=mongo.db.productos.find({})
#     r=dumps(data)
#     return r
@prod.route('/productos/get_all', methods=['GET'])
def get_productos():
    data=mongo.db.productos.find({}) # ,{"_id":0}
    r = []
    for producto in data:
        producto['_id'] = str(producto['_id']) # Convertir ObjectId a cadena
        r.append(producto)
    return r
#r=list(data)
#return r

#Método que retorna un producto por nombre
@prod.route('/productos/porNombre/<string:nombre>', methods=['GET'])
def obtener_PorNombre(nombre):
    #nom="tijeras"
    query={'nombre':{'$eq':nombre}}
    sort = [("nombre", 1)]
    project = {"_id":0,"nombre": 1, "precio":1, 'descripcion':1}
    try:
        resultado = mongo.db.productos.find(query, project).sort(sort)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return list(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
        
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#Método que retorna un producto por id
@prod.route('/productos/porID/<string:id>', methods=['GET'])
def obtener_PorID(id):
    query={'_id':ObjectId(id)}
    project = {"_id":0,"nombre": 1, "cantidadExistente":1, "costo":1 }
    try:
        resultado=mongo.db.productos.find_one(query, project)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus
        return jsonify({"error": str(e)}), 500

#Inner Join
@prod.route('/productos/prod_prov', methods=['GET'])
def obtener_prod_prov():
    query = [
        {
            '$lookup': {
                'from': "proveedores",
                'localField': "proveedorId",
                'foreignField': "_id",
                'as': "proveedor"
            }
        },
        {
            '$unwind': "$proveedor" # Deshacer el array creado por $lookup
        },
        {
            '$project': {
                "_id": 0,
                "clave":1,
                "nombre": 1,
                "precio": 1,
                "version": 1,
                "status": 1,
                "origen":1,
                "descripcion": 1,
                "proveedor.RFC": 1,
                "proveedor.nombProv": 1,
                "proveedor.tel":1,
                "proveedor.paginaweb":1
            }
        }
    ]
    try:
        resultado = mongo.db.productos.aggregate(query)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return list(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

@prod.route('/productos/nuevoProd', methods=['POST'])
def add_producto():
    #from flask import request
    clave=request.json["clave"]
    nombre=request.json["nombre"]
    nombCat=request.json["categoria"]["nombCat"]
    descCat=request.json["categoria"]["descCat"]
    marca=request.json["marca"]
    consola=request.json["consola"]
    version=request.json['version']
    numjugadores=request.json["numjugadores"]
    descripcion=request.json["descripcion"]
    costo=request.json["costo"]
    precio=request.json["precio"]
    foto=request.json["foto"]
    fecha_srt=request.json["fecha_adquisicion"]
    # Convertir la cadena de fecha a un objeto date
    fecha_adquisicion=datetime.strptime(fecha_srt, "%Y-%m-%d")
    cantidadExistente=request.json["cantidadExistente"]
    status=request.json["status"]
    origen=request.json["origen"]
    proveedorId=request.json["proveedorId"]
    idiomaId=request.json["idiomaId"]

    if request.method =='POST':
        product={"clave": clave,
            "nombre": nombre,
            "categoria":{"nombCat" :nombCat,"descripcion":descCat},
            "marca":marca,
            "consola":consola,
            "version":version,
            "numjugadores":numjugadores,
            "descripcion":descripcion,
            "costo": costo,
            "precio": precio,
            'foto': foto,
            "fecha_adquisicion": fecha_adquisicion,
            "cantidadExistente":cantidadExistente,
            "status":status,
            "origen":origen,
            "proveedorId":proveedorId,
            "idiomaId":idiomaId}


    try:
        resultado = mongo.db.productos.insert_one(product)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento insertado"})
        else:
            # Si no se pudo insertar el documento, devuelve un mensaje
            return jsonify({"mensaje": "Documento no insertado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#Eliminar un porducto por ID
@prod.route('/productos/eliminar/<string:id>', methods=['DELETE'])
def eliminar (id):
    try:
        resultado = mongo.db.productos.delete_one({'_id':ObjectId(id)})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "documento eliminado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500


#Actualizar un producto por ID
@prod.route('/productos/actualizar/<string:id>', methods=['PUT'])
def actualizar(id):
    nuevoNombre =request.json["nombre"] 
    nuevacantidad=request.json["cantidadExistente"]
    nuevo_costo=request.json["costo"]

    try:
        resultado=mongo.db.productos.update_one({'_id':ObjectId(id)}, {"$set":{"nombre":nuevoNombre, "cantidadExistente":nuevacantidad,"costo":nuevo_costo }})
        actualizar_precio(id, nuevo_costo)
        if resultado:

            actualizar_precio (id, nuevo_costo)
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
def actualizar_precio(id, nuevo_costo):
    try:
        resultado = mongo.db.productos.update_one({'_id':ObjectId(id)},{"$set": {"precio":nuevo_costo+(nuevo_costo*20/100)}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
def actualizar_precio (id, nuevo_costo):
    try:
        resultado = mongo.db.productos.update_one({'_id':ObjectId(id)},{"$set": {"precio":nuevo_costo+(nuevo_costo*20/100)}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500