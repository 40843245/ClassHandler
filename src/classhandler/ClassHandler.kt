package classhandler

class ClassHandler(
    val cls: Class<*>,
) {
    fun getFieldsName():List<String>{
        val fieldsName = mutableListOf<String>()

        val declaredFields = cls.declaredFields
        val fields = cls.fields
        for (declaredField in declaredFields) {
            if (declaredField.name !in fields.map { it.name }) {
                fieldsName.add(declaredField.name)
            }
        }

        return fieldsName.toList()
    }

    fun getFieldsValue(obj:Any):List<Any?>{
        val fieldsValue = mutableListOf<Any?>()

        val declaredFields = cls.declaredFields
        val fields = cls.fields
        for (declaredField in declaredFields) {
            if (declaredField.name !in fields.map { it.name }) {
                declaredField.isAccessible = true
                val value = declaredField.get(obj)
                fieldsValue.add(value)
            }
        }

        return fieldsValue.toList()
    }



}