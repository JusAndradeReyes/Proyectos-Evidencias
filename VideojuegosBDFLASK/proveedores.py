import datetime
from bson import ObjectId
from mongo import mongo
from flask import Blueprint, jsonify, request
from bson.json_util import dumps

#creación del módulo
prove=Blueprint("provee", __name__)

@prove.route('/proveedores/get_all', methods=['GET'])
# def listar_prove():
#     data=mongo.db.proveedores.find({})
#     r=dumps(data)
#     return r
def get_proveedores():
    data=mongo.db.proveedores.find({}) # ,{"_id":0}
    r = []
    for proveedor in data:
        proveedor['_id'] = str(proveedor['_id']) # Convertir ObjectId a cadena
        r.append(proveedor)
    return r
#r=list(data)
#return r

#Método que retorna un proveedor por nombre
@prove.route('/proveedores/porNombre/<string:nombre>', methods=['GET'])
def obtener_PorNombre(nombre):
    #nom="tijeras"
    query={'nombProv':{'$eq':nombre}}
    sort = [("nombProv", 1)]
    project = {"_id":0,"nombProv": 1, "RFC":1, 'paginaweb':1}
    try:
        resultado = mongo.db.proveedores.find(query, project).sort(sort)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return list(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
        
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
#Método que retorna un proveedor por id
@prove.route('/proveedores/porID/<string:id>', methods=['GET'])
def obtener_PorID(id):
    query={'_id':id}
    project = {"_id":0,"nombProv": 1, "RFC":1, "    ":1}
    try:
        resultado=mongo.db.proveedores.find_one(query, project)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus
        return jsonify({"error": str(e)}), 500
    
#----------------------------INSERTAR PROVEEDOR----------------------------------
@prove.route('/proveedores/nuevoProve', methods=['POST'])
def add_proveedor():
    #from flask import request
    id=request.json["_id"]
    nomP=request.json["nombProv"]
    rfc=request.json["RFC"]
    tel=request.json["tel"]
    pw=request.json["paginaweb"]
    dir_calle=request.json["direccion"]["calle"]
    dir_num=request.json["direccion"]["numero"]
    dir_col=request.json["direccion"]["colonia"]
    dir_mun=request.json["direccion"]["municipio"]
    dir_es=request.json["direccion"]["estado"]
    dir_cp=request.json["direccion"]["cp"]

    if request.method =='POST':
        product={"_id": id,
        "nombProv": nomP,
        "RFC": rfc,
        "tel": tel,
        "paginaweb": pw,
        "direccion": {
            "calle": dir_calle,
            "numero": dir_num,
            "colonia": dir_col,
            "municipio": dir_mun,
            "estado": dir_es,
            "cp": dir_cp}}


    try:
        resultado = mongo.db.proveedores.insert_one(product)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento insertado"})
        else:
            # Si no se pudo insertar el documento, devuelve un mensaje
            return jsonify({"mensaje": "Documento no insertado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#--------------------------------Eliminar un proveedor por ID------------------------------------
@prove.route('/proveedores/eliminar/<string:id>', methods=['DELETE'])
def eliminar (id):
    try:
        resultado = mongo.db.proveedores.delete_one({'_id':id})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "documento eliminado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#------------------------------Actualizar un proveedor por ID------------------------------------
@prove.route('/proveedores/actualizar/<string:id>', methods=['PUT'])
def actualizar_telefono(id):
    nuevo_tel=request.json["tel"]
    nuevonombProv=request.json["nombProv"] 
    nuevoRFC =request.json["RFC"] 
    try:
        resultado = mongo.db.proveedores.update_one({'_id':id},{"$set": {"tel":nuevo_tel, "nombProv":nuevonombProv, "RFC":nuevoRFC}})
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
        resultado = mongo.db.proveedores.update_one({'_id':id},{"$set": {"tel": nuevo_tel}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500