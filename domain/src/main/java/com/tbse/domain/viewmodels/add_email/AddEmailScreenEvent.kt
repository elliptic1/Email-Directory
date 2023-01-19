package com.tbse.domain.viewmodels.add_email

/**
 * Created by toddsmith on 1/15/23.
 */
sealed class AddEmailScreenEvent {

    object Default : AddEmailScreenEvent()

    object EmailAdded : AddEmailScreenEvent()

    object TransientMessageFinished : AddEmailScreenEvent()

    object Error : AddEmailScreenEvent()

}
