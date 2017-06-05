/*
C:\ProgramData\MySQL\MySQL Server 5.7\Uploads
C:\Program Files\MongoDB\Server\3.4\bin

*/

select t.categoryId, t.categoryName from imse.category t
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/category.csv' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n';

select t.productId,t.productName,t.price,t.description,t.quantity from imse.product t
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/product.csv' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n';
    
select t.categoryId,t.productId from imse.productbelongscategory t 
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/cat2prod.csv' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n';

select t.imageId,t.productId,t.image from imse.image t
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/image.csv' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n';

mongoimport --host 127.0.0.1 --port 27017 --db online_shop --collection CATEGORY --type csv -f CATEGORYID,CATEGORYNAME  --file "C:\ProgramData\MySQL\MySQL Server 5.7\Uploads\category.csv"
mongoimport --host 127.0.0.1 --port 27017 --db online_shop --collection imp_product --type csv -f PRODUCTID,PRODUCTNAME,PRICE,DESCRIPTION,QUANTITY  --file "C:\ProgramData\MySQL\MySQL Server 5.7\Uploads\product.csv"
mongoimport --host 127.0.0.1 --port 27017 --db online_shop --collection imp_cat2prod --type csv -f categoryId,productId  --file "C:\ProgramData\MySQL\MySQL Server 5.7\Uploads\cat2prod.csv"
mongoimport --host 127.0.0.1 --port 27017 --db online_shop --collection imp_image --type csv -f IMAGEID,PRODUCTID,IMAGE  --file "C:\ProgramData\MySQL\MySQL Server 5.7\Uploads\image.csv"

db.imp_cat2prod.aggregate([
{
	$lookup:
	{
            from: "CATEGORY",
            localField: "categoryId",
            foreignField: "CATEGORYID",
            as: "cats"
	}
},
{
    $project: {
		_id: 1, "productId": 1, cat_id: "$cats._id"
	}
},
    { $unwind : "$cat_id" }
]).forEach(function(doc){
	db.imp_cat2prod_catid.insert(doc);
});

db.imp_cat2prod.drop();


db.imp_product.aggregate([
	{
		$lookup:
		{
			from: "imp_cat2prod_catid",
			localField: "PRODUCTID",
			foreignField: "productId",
			as: "CATEGORIES"
		}
	},
	{
		$project: {
			_id: 1, "PRODUCTID": 1, "PRODUCTNAME": 1, "PRICE": 1, "DESCRIPTION": 1, "QUANTITY": 1,
                        "CATEGORIES__id" : "$CATEGORIES.cat_id"
		}
	},
        {
		$lookup:
		{
			from: "imp_image",
			localField: "PRODUCTID",
			foreignField: "PRODUCTID",
			as: "IMAGES"
		}
	},
	{
		$project: {
			_id: 1, "PRODUCTID": 1, "PRODUCTNAME": 1, "PRICE": 1, "DESCRIPTION": 1, "QUANTITY": 1,
            "CATEGORIES__id" : 1,
            "IMAGES" : { "IMAGEID": 1, "IMAGE": 1}
		}
	}
]).forEach(function(doc){
	db.PRODUCT.insert(doc);
});


db.imp_image.drop();
db.imp_cat2prod_catid.drop();
db.imp_product.drop();

#db.PRODUCT.ensureIndex({PRODUCTNAME:"text"});
#db.PRODUCT.find({$text:{$search:"Kissenbezug"}});
#db.PRODUCT.find({"PRODUCTNAME": /.*bat.*/});
#db.PRODUCT.aggregate([
#    { $match: { PRODUCTNAME: /.*bat.*/ } },
#    { $unwind : "$CATEGORIES__id"},
#    {
#       $group:
#         {
#           _id: "$CATEGORIES__id",
#           count: { $sum: 1 }
#         }
#     }
#]);


#db.PRODUCT.aggregate([
#    { $match: { PRODUCTNAME: /.*bat.*/ } },
/*    {
        $lookup:
        {
            from: "CATEGORY",
            localField: "CATEGORIES__id",
            foreignField: "_id",
            as: "CATEGORIES"
        }
    },
    {
        $project: { "PRODUCTID": 1, "PRODUCTNAME": 1, "PRICE": 1, "DESCRIPTION": 1, "QUANTITY": 1,
            "CATEGORIES" : "$CATEGORIES.CATEGORYID"
            , "IMAGES" : "$IMAGES.IMAGE"
        , isCat: { $setIsSubset: [ "$CATEGORIES.CATEGORYID", [6] ] } } 
    },
    { $match: { isCat: true } },
    {
	$project: {
            _id: 0, "PRODUCTID": 1, "PRODUCTNAME": 1, "PRICE": 1, "DESCRIPTION": 1, "QUANTITY": 1,
            "CATEGORIES" : "$CATEGORIES.CATEGORYID"
            , "IMAGES" : "$IMAGES.IMAGE"
	}
    },
    { $sort : { PRICE : -1 } },
    { $skip: 10 },
    { $limit : 10 }
]);
*/