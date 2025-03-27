from flask import Flask, request, jsonify

app = Flask(__name__)

# Simulación de base de datos
productos = []
facturas = []

# Rutas para Productos
@app.route('/v1/productos', methods=['GET'])
def get_productos():
    return jsonify(productos), 200

@app.route('/v1/productos/<int:id>', methods=['GET'])
def get_producto(id):
    producto = next((p for p in productos if p['id'] == id), None)
    if producto:
        return jsonify(producto), 200
    return jsonify({'error': 'Producto no encontrado'}), 404

@app.route('/v1/productos', methods=['POST'])
def create_producto():
    data = request.json
    productos.append(data)
    return jsonify(data), 201

@app.route('/v1/productos/<int:id>', methods=['PUT'])
def update_producto(id):
    data = request.json
    for producto in productos:
        if producto['id'] == id:
            producto.update(data)
            return jsonify(producto), 200
    return jsonify({'error': 'Producto no encontrado'}), 404

@app.route('/v1/productos/<int:id>', methods=['DELETE'])
def delete_producto(id):
    global productos
    productos = [p for p in productos if p['id'] != id]
    return jsonify({'message': 'Producto eliminado'}), 200

# Rutas para Facturas
@app.route('/v1/facturas', methods=['GET'])
def get_facturas():
    return jsonify(facturas), 200

@app.route('/v1/facturas/<int:id>', methods=['GET'])
def get_factura(id):
    factura = next((f for f in facturas if f['id'] == id), None)
    if factura:
        return jsonify(factura), 200
    return jsonify({'error': 'Factura no encontrada'}), 404

@app.route('/v1/facturas', methods=['POST'])
def create_factura():
    data = request.json
    facturas.append(data)
    return jsonify(data), 201

@app.route('/v1/facturas/<int:id>', methods=['PUT'])
def update_factura(id):
    data = request.json
    for factura in facturas:
        if factura['id'] == id:
            factura.update(data)
            return jsonify(factura), 200
    return jsonify({'error': 'Factura no encontrada'}), 404

@app.route('/v1/facturas/<int:id>', methods=['DELETE'])
def delete_factura(id):
    global facturas
    facturas = [f for f in facturas if f['id'] != id]
    return jsonify({'message': 'Factura eliminada'}), 200

if __name__ == '__main__':
    app.run(debug=True)
