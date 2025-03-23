from bson import ObjectId
from app import create_app
from mongo import mongo
from flask import Blueprint, jsonify, request
from bson.json_util import dumps
from datetime import datetime

#creación del módulo
carr=Blueprint("carr", __name__)

#---------------------Método que retorna todos los carritos-----------------------
@carr.route('/carritos/get_all', methods=['GET'])
def listar_carritos():
    data=mongo.db.carritos.find({})
    r=dumps(data)
    return r

#-----------------------Método que retorna un carrito por id------------------------------
@carr.route('/carritos/porID/<string:id>', methods=['GET'])
def obtener_PorID(id):
    query={'_id':id}
    project = {"_id":1,"listaProd": 1,"clienteId":1}
    try:
        resultado=mongo.db.carritos.find_one(query, project)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus
        return jsonify({"error": str(e)}), 500

#----------------------------INSERTAR CARRITOS----------------------------------
@carr.route('/carritos/nuevoCarrito', methods=['POST'])
def add_carrito():
    #from flask import request
    id=request.json["_id"]
    listp=request.json["listaProd"]
    fecha_srt=request.json["fecha_creacion"]
    # Convertir la cadena de fecha a un objeto date
    fechaCrea=datetime.strptime(fecha_srt, "%Y-%m-%d")
    cliId=request.json["clienteId"]

    if request.method =='POST':
        product={"_id":id,
            "listaProd":listp,
            "fecha_creacion":fechaCrea,
            "clienteId":cliId
            }

    try:
        resultado = mongo.db.carritos.insert_one(product)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento insertado"})
        else:
            # Si no se pudo insertar el documento, devuelve un mensaje
            return jsonify({"mensaje": "Documento no insertado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
#---------------------------------Inner Join---------------------------------------------------------
@carr.route('/carritos/carr_clie', methods=['GET'])
def obtener_carr_clie():
    query = [
        {
            '$lookup': {
                'from': "clientes",
                'localField': "clienteId",  
                'foreignField': "_id",
                'as': "cliente"
            }
        },
        {
            '$unwind': "$cliente" # Deshacer el array creado por $lookup
        },
        {
            '$project': {
                "listaProd":1,
                "fecha_creacion": 1,
                "cliente.nomcliente.nombre": 1,
                "cliente.nomcliente.appellido1": 1,
                "cliente.nomcliente.apellido2": 1,
                "cliente.direccion.pais": 1,
                "cliente.direccion.provincia": 1
            }
        }   
    ]
    try:
        resultado = mongo.db.carritos.aggregate(query)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return list(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#--------------------------------Eliminar un carrito por ID------------------------------------
@carr.route('/carritos/eliminar/<string:id>', methods=['DELETE'])
def eliminar (id):
    try:
        resultado = mongo.db.carritos.delete_one({'_id':id})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "documento eliminado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#-----------------------------Actualizar un carrito por ID----------------------------------------
@carr.route('/carritos/actualizar/<string:id>', methods=['PUT'])
def actualizar_listaProd(id):
    nueva_listaProd=request.json["listaProd"]
    try:
        resultado = mongo.db.carritos.update_one({'_id':id},{"$set": {"listaProd":nueva_listaProd}})
        if resultado:
            actualizar_listaProd(id, nueva_listaProd)
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
def actualizar_listaProd(id, nueva_listaProd):
    try:
        resultado = mongo.db.carritos.update_one({'_id':id},{"$set": {"listaProd":nueva_listaProd}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
def actualizar_listaProd(id, nueva_listaProd):
    try:
        resultado = mongo.db.carritos.update_one({'_id':id},{"$set": {"listaProd":nueva_listaProd}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500