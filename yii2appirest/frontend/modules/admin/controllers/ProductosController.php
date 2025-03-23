<?php

namespace frontend\modules\admin\controllers;
use frontend\models\Productos;
use Yii;
use yii\filters\AccessControl;
use yii\rest\ActiveController;

class ProductosController extends ActiveController
{
    public $modelClass='frontend\models\Productos';
    public $serializer=[
        'class'=> 'yii\rest\Serializer',
        'collectionEnvelope'=>'items'
    ];

    public function init(){
        parent::init();
        \Yii::$app->user->enableSession=false;
    }
}

//http://localhost/yii2appirest/frontend/web/index.php?r=api/productos
