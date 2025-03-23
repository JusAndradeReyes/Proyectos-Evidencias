from bson import ObjectId
from app import create_app
from mongo import mongo
from flask import Blueprint, jsonify, request
from bson.json_util import dumps
from datetime import datetime

#creación del módulo
clie=Blueprint("clie", __name__)

#----------------Método que retorna todos los clientes-----------------------------
@clie.route('/clientes/get_all', methods=['GET'])
# def listar_pclie():
#     data=mongo.db.clientes.find({})
#     r=dumps(data)
#     return r
def get_clientes():
    data=mongo.db.clientes.find({}) # ,{"_id":0}
    r = []
    for cliente in data:
        cliente['_id'] = str(cliente['_id']) # Convertir ObjectId a cadena
        r.append(cliente)
    return r
#r=list(data)
#return r

#----------------Método que retorna un cliente por nombre-----------------------------
@clie.route('/clientes/porNombre/<string:nombre>', methods=['GET'])
def obtener_PorNombre(nombre):
    query={'nomcliente.nombre':{'$eq':nombre}}
    sort = [("nomcliente.nombre", 1)]
    project = {"_id":1,"nomcliente.nombre": 1, "direccion.pais":1, 'telefonos':1}
    try:
        resultado = mongo.db.clientes.find(query, project).sort(sort)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return list(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
        
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#-----------------------Método que retorna un cliente por id------------------------------
@clie.route('/clientes/porID/<string:id>', methods=['GET'])
def obtener_PorID(id):
    query={'_id':id}
    project = {"_id":1,"nomcliente.nombre": 1, "direccion.pais":1, "telefonos":1}
    try:
        resultado=mongo.db.clientes.find_one(query, project)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus
        return jsonify({"error": str(e)}), 500

#----------------------------INSERTAR CLIENTES----------------------------------
@clie.route('/clientes/nuevoCliente', methods=['POST'])
def add_cliente():
    #from flask import request
    id=request.json["_id"]
    nom_nom=request.json["nomcliente"]["nombre"]
    nom_ape1=request.json["nomcliente"]["apellido1"]
    nom_ape2=request.json["nomcliente"]["apellido2"]
    fecha_srt=request.json["fecha_nac"]
    # Convertir la cadena de fecha a un objeto date
    fechaNac=datetime.strptime(fecha_srt, "%Y-%m-%d")
    dir_pa=request.json["direccion"]["pais"]
    dir_pro=request.json["direccion"]["provincia"]
    tel=request.json["telefonos"]

    if request.method =='POST':
        product={"_id":id,
            "nomcliente": {
            "nombre":nom_nom,
            "apellido1":nom_ape1,
            "apellido2":nom_ape2},
            "fecha_nac":fechaNac,
            "direccion":{
            "pais":dir_pa,
            "provincia":dir_pro},
            "telefonos":tel
            }


    try:
        resultado = mongo.db.clientes.insert_one(product)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento insertado"})
        else:
            # Si no se pudo insertar el documento, devuelve un mensaje
            return jsonify({"mensaje": "Documento no insertado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#--------------------------------Eliminar un clientes por ID------------------------------------
@clie.route('/clientes/eliminar/<string:id>', methods=['DELETE'])
def eliminar (id):
    try:
        resultado = mongo.db.clientes.delete_one({'_id':id})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "documento eliminado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#------------------------------Actualizar un cliente por ID------------------------------------
@clie.route('/clientes/actualizar/<string:id>', methods=['PUT'])
def actualizar_telefono(id):
    nuevo_tel=request.json["telefonos"]
    try:
        resultado = mongo.db.clientes.update_one({'_id':id},{"$set": {"telefonos":nuevo_tel}})
        if resultado:
            actualizar_telefono (id, nuevo_tel)
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
def actualizar_telefono(id, nuevo_tel):
    try:
        resultado = mongo.db.clientes.update_one({'_id':id},{"$set": {"telefonos": nuevo_tel}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500