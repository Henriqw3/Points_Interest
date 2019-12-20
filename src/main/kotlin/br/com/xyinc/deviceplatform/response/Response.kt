/* Response Class
* Gerenciador de respostas para a padronização
* dos retornos dos controladores da API
 */

package br.com.xyinc.deviceplatform.response

class Response<T> (
        val erros: ArrayList<String> = arrayListOf(),
        var dados: T? = null

)