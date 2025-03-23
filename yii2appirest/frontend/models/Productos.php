<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "productos".
 *
 * @property int $ID
 * @property string $Nombre
 * @property string|null $Descripcion
 * @property float $Precio
 * @property int $Stock
 */
class Productos extends \yii\db\ActiveRecord
{
    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'productos';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['Nombre', 'Precio', 'Stock'], 'required'],
            [['Descripcion'], 'string'],
            [['Precio'], 'number'],
            [['Stock'], 'integer'],
            [['Nombre'], 'string', 'max' => 100],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'ID' => 'ID',
            'Nombre' => 'Nombre',
            'Descripcion' => 'Descripcion',
            'Precio' => 'Precio',
            'Stock' => 'Stock',
        ];
    }
}
