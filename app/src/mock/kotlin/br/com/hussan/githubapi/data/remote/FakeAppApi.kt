package br.com.hussan.githubapi.data.remote

import br.com.hussan.githubapi.data.model.*
import br.com.hussan.githubapi.data.model.request.*
import br.com.hussan.githubapi.data.model.response.*
import br.com.hussan.githubapi.extensions.asGB
import br.com.hussan.githubapi.extensions.asMB
import br.com.hussan.githubapi.extensions.dateOf
import io.reactivex.Observable
import retrofit2.Call
import java.util.*
import java.util.concurrent.TimeUnit

class FakeAppApi : AppApi {

    override fun requestTokenSync(request: TokenRequest): Call<TokenRequestResponse>? {
        return null
    }
    override fun requestToken(request: TokenRequest): Observable<TokenRequestResponse> =
            TokenRequestResponse("", emptyList(), "", TokenResponseReturn(token = "123")).run {
                Observable.just(this)
            }

    override fun requestSMSCode(appToken: String, request: SMSCodeRequest): Observable<SMSCodeResponse> =
            SMSCodeResponse(`return` = SMSCodeResponseReturn("hussan", "pass", "1")).run { Observable.just(this) }

    override fun authenticateCode(appToken: String, request: AuthenticateRequest): Observable<Any> = Observable.just(Any())

    override fun resendSMSCode(appToken: String, request: ResendSMSCodeRequest): Observable<Any> = Observable.just(Any())

    override fun getOrderDetail(userToken: String, orderId: String, idLine: String): Observable<GetOrderDetailResponse>
            = GetOrderDetailResponse("", emptyList(), "", OrderDetail("A3259557", "nextel", "Portabilidade", "Vivo Controle Giga 2,5GB",
            listOf(OrderDetailStep("Análise de crédito", true, dateOf(14, 2, 2016)),
                    OrderDetailStep("Ativação de serviço", false, dateOf(14, 2, 2016), true),
                    OrderDetailStep("Preparando para envio", false, null),
                    OrderDetailStep("Enviado à transportadora", false, null),
                    OrderDetailStep("Entregue ao cliente", false, null))))
            .run { Observable.just(this) }

    override fun getConsumerData(telephone: String?): Observable<Consumer> {
        // For test with 2 types of users
        val consumer: Consumer

        if (telephone?.equals("45988137777") ?: false)
            consumer = Consumer(null, "45988137777", null, false)
        else
            consumer = Consumer("Houssan A. Hijazi", "4588130770", registered = true, plan = Plan(cycle = Date(), dueDate = Date(), name = "Claro Controle 1.5GB", operator = "Claro", callSeconds = 1000, mobileBytes = 1073741824L))

        return consumer.run { Observable.just(this) }

    }


    override fun purchase(planId: String?): Observable<Any> = Observable.just(Any())
            .delay(2, TimeUnit.SECONDS)

    override fun getPlanOffers(): Observable<List<PlanOffer>> {
        return listOf(
                PlanOffer("12", "Claro Controle 500MB", 500L.asMB(), 9.90, "http://www.google.com",
                        arrayListOf("R$ 5,00 de saldo livre", "Ligações à vontade para Claro, Claro Fone e NET Fone"), "PRÉ", true),
                PlanOffer("12", "Claro Controle 1GB", 1L.asGB(), 19.90, "http://www.google.com",
                        arrayListOf("R$ 10,00 de saldo livre", "Ligações à vontade para Claro, Claro Fone e NET Fone"), "PRÉ", false),
                PlanOffer("123", "Claro Controle 1,5GB", 1.5.asGB().toLong(), 49.90, "http://www.google.com",
                        arrayListOf("R$ 15,00 de saldo livre", "WhatsApp sem descontar da internet", "Ligações à vontade para Claro, Claro Fone e NET Fone"), "PRÉ", false),
                PlanOffer("1234", "Claro Controle 2GB", 2L.asGB(), 59.90, "http://www.google.com",
                        arrayListOf("R$ 25,00 de saldo livre", "WhatsApp sem descontar da internet", "SMS ilimitado", "Ligações à vontade para Claro, Claro Fone e NET Fone"), "PRÉ", false),
                PlanOffer("12345", "Claro Controle 5GB", 5L.asGB(), 69.90, "http://www.google.com",
                        arrayListOf("R$ 50,00 de saldo livre", "WhatsApp sem descontar da internet", "SMS ilimitado", "Ligações à vontade para Claro, Claro Fone e NET Fone"), "PRÉ", false)
        ).run { Observable.just(this) }
    }

    override fun getAddress(cep: String): Observable<Address> = Address("Av. Brasil", "Centro", "São Paulo", "SP")
            .run { Observable.just(this) }

    override fun saverOrder(orderRequest: OrderRequest): Observable<Any> = Observable.just(Any())
            .delay(2, TimeUnit.SECONDS)

    override fun getOrders(userToken: String, idLine: String): Observable<GetOrdersResponse> {
        return GetOrdersResponse("", emptyList(), "", GetOrdersResponseReturn(listOf(
                OrderDetail("A3259557", "vivo", "Portabilidade", "Vivo Controle Giga 2,5GB",
                listOf(OrderDetailStep("Análise de crédito", true, dateOf(14, 2, 2016)),
                        OrderDetailStep("Ativação de serviço", false, dateOf(14, 2, 2016), true),
                        OrderDetailStep("Preparando para envio", false, null),
                        OrderDetailStep("Enviado à transportadora", false, null),
                        OrderDetailStep("Entregue ao cliente", false, null))),
                OrderDetail("A3259558", "vivo", "Portabilidade", "Vivo Controle Giga 1,5GB",
                        listOf(OrderDetailStep("Análise de crédito", true, dateOf(14, 2, 2016)),
                                OrderDetailStep("Ativação de serviço", false, null),
                                OrderDetailStep("Preparando para envio", false, null),
                                OrderDetailStep("Enviado à transportadora", false, null),
                                OrderDetailStep("Entregue ao cliente", false, null))))
                ))
                .run { Observable.just(this) }

    }
    override fun sendFCMToken(appToken: String, request: FCMTokenRequest): Observable<Any> {
        return Observable.just(Any())
    }
    override fun getOperatorContacts(userToken: String, idLine: String): Observable<GetContactsResponse> {
        return GetContactsResponse("", emptyList(), "", GetContactsResponseReturn(
                listOf(OperatorContact("CLARO", "claro@claro.com.br", "9999-12345"))
        )).run { Observable.just(this) }
    }
    override fun syncAllStatisticsHistory(userToken: String, request: StatisticsRequest): Observable<SyncAllStatisticsHistoryResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
