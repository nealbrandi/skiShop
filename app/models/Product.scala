package models

/**
 * An entry in the product catalogue.
 *
 * @param ean EAN-13 code - a unique product identifier
 * @param name Product name
 * @param description Product description
 */
case class Product(ean: Long, name: String, description: String) {
  override def toString = "%s - %s".format(ean, name)
}

/**
 * Products data access
 */
object Product {
  
  var products = Set(
    Product(5010255079763L, "K2 AMP Rictor 90XTI", "Inheriting a split personality from two different categories, K2's popular Rictor takes on a wide 90mm waist to bridge All-Mountain performance with hard-charging Freeride skis."),
    Product(5018206244666L, "K2 AMP Bolt", "K2’s flagship precision piste performance ski is the ultimate carving tool for making medium to long-radius turns at high speeds on firmer snow pack. The combination of a rock solid construction, shape and profile ensures unshakeable hold and expert accuracy without any hesitancy."),
    Product(5018306332812L, "Rossignol Experience 100 Ti Open", "The all-new EXPERIENCE 100 is the ultimate one-ski-quiver for expert all-mountain skiers."),
    Product(5018306312913L, "4FRNT Signature Raven", "This negative camber, 102 mm waist shape, provides the surfy and buoyant feel of The HOJI and Renegade in powder yet with a quick turning 23/30M tapered dual radius sidecut for firm conditions."),
    Product(5018206244611L, "Atomic Nomad Blackeye Ti", "The Atomic Nomad Blackeye TI is an all-mountain performance ski that excels both on piste and off the side.")
  )

  /**
   * Products sorted by EAN code.
   */
  def findAll = products.toList.sortBy(_.ean)

  /**
   * The product with the given EAN code.
   */
  def findByEan(ean: Long) = products.find(_.ean == ean)

  /**
   * Products whose name matches the given query.
   */
  def findByName(query: String) = products.filter(_.name.contains(query))

  /**
   * Deletes a product from the catalog.
   */
  def remove(product: Product) = {
    val oldProducts = products
    products = products - product
    oldProducts.contains(product)
  }

  /**
   * Adds a product to the catalog.
   */
  def add(product: Product) {
    products = products + product
  }
}
